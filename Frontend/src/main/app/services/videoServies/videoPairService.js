import generateSingleVideo from "./generateSingleVideoService.js";

async function fetchRandomVideoPair(callback) {
    $.get("http://localhost:9090/Backend_war_exploded/getRandomVideosPair", callback);
}

async function fetchSpecificVideoPair(firstVideoId, secondVideoId, callback) {
    $.get("http://localhost:9090/Backend_war_exploded/generateSpecificVideosPair", {
        id1: firstVideoId,
        id2: secondVideoId
    }, callback)
}

export default function generateVideoPair() {
    let urlParams = new URLSearchParams(window.location.search);
    let firstVideoId = urlParams.get("id1");
    let secondVideoId = urlParams.get("id2");
    (firstVideoId && secondVideoId) ?
        fetchSpecificVideoPair(firstVideoId, secondVideoId, fetchVideoCallback)
        :
        fetchRandomVideoPair(fetchVideoCallback);
}

function fetchVideoCallback(data) {
    let videoPairData = JSON.parse(data);
    let videoPairDiv = document.getElementById("videoPair");
    videoPairDiv.innerHTML = "";
    videoPairDiv.appendChild(generateSingleVideo(videoPairData, 0));
    videoPairDiv.appendChild(generateSingleVideo(videoPairData, 1));
}

