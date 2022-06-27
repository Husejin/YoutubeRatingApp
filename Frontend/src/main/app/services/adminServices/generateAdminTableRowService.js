import deleteVideoHandler from "./adminDeleteService.js";
import editVideoHandler from "./adminUpdateService.js";

export default function generateRankTableRow(videoData, videoIndex, pageIndex) {
    let tableRow = document.createElement("div");
    tableRow.className = "tableRow";
    tableRow.setAttribute("id", videoData.id);
    let headerHeadLine = document.createElement("div");
    headerHeadLine.className = "headerHeadline";
    let headlineInfo = document.createElement("div");
    headlineInfo.className = "headlineInfo";
    let thumbnail = document.createElement("img");
    thumbnail.src = (videoData.alternateImage) ?  `data:image/png;base64,${videoData.alternateImage}` :  videoData.thumbnailUrl;
    let songTitle = document.createElement("div");
    songTitle.className = "songTitle";
    songTitle.textContent = videoData.name;
    headlineInfo.appendChild(thumbnail);
    headlineInfo.appendChild(songTitle);
    headerHeadLine.appendChild(headlineInfo);
    let headerVotes = document.createElement("div");
    headerVotes.className = "headerVotes";
    let headlineInfo2 = document.createElement("div");
    headlineInfo2.className = "headlineInfo";
    headlineInfo2.textContent = videoData.positiveVotes + "/" + videoData.allVotes;
    headerVotes.appendChild(headlineInfo2);
    let headerRank = document.createElement("div");
    headerRank.className = "headerVotes";
    let headlineInfo3 = document.createElement("div");
    headlineInfo3.className = "headlineInfo";
    headlineInfo3.textContent = (videoIndex + (pageIndex * 20) + 1);
    let editVideo = document.createElement("div");
    editVideo.className = "editCog";
    let editIcon = document.createElement("i");
    editIcon.className = "fa fa-cog";
    editVideo.appendChild(editIcon);
    editVideo.onclick=editVideoHandler;

    let deleteVideo = document.createElement("div");
    deleteVideo.className = "editCog";
    let deleteIcon = document.createElement("i");
    deleteIcon.className = "fa fa-trash";
    deleteVideo.appendChild(deleteIcon);
    deleteVideo.onclick=deleteVideoHandler;

    headerRank.appendChild(headlineInfo3);
    tableRow.appendChild(headerHeadLine);
    tableRow.appendChild(headerVotes);
    tableRow.appendChild(headerRank);
    tableRow.appendChild(editVideo);
    tableRow.appendChild(deleteVideo);

    return tableRow;
}