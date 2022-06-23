import generateVideoPair from "./videoPairService.js";

function updateVideo(idToUpdate, idToRemain) {
    $.post("http://localhost:9090/Backend_war_exploded/updateVideoVote", {
        idToUpdate: idToUpdate,
        idToRemain: idToRemain
    }, () => {
    });
}
export async function fetchSpecificVideo(videoId,callback)
{
    $.get("http://localhost:9090/Backend_war_exploded/generateSpecificVideo", {
        id: videoId
    }, callback)
}
export default function generateSingleVideo(videoPairData, videoIndex) {
    let sv = document.createElement("div");
    sv.setAttribute("id",videoPairData[videoIndex].id);
    sv.className = "singleVideo";
    let lbl = document.createElement("label");
    lbl.className = "videoLabel";
    lbl.textContent = videoPairData[videoIndex].name;
    let iFrame = document.createElement("iframe");
    iFrame.src = videoPairData[videoIndex].url;
    let btn = document.createElement("button");
    btn.className = "voteButton";
    btn.textContent = "vote";
    btn.onclick = () => {
        (videoIndex === 0) ? updateVideo(videoPairData[0].id, videoPairData[1].id) : updateVideo(videoPairData[1].id, videoPairData[0].id);
        window.history.pushState({}, document.title, window.location.pathname);
        generateVideoPair();
    }
    sv.appendChild(lbl);
    sv.appendChild(iFrame);
    sv.appendChild(btn);

    return sv;
}