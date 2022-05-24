import generateSingleVideo from "./generateSingleVideoService.js";

async function fetchRandomVideoPair(callback) {
    $.get("http://localhost:9090/Backend_war_exploded/getRandomVideosPair", callback);
}


export default function generateVideoPair() {
    fetchRandomVideoPair((data) => {
        let videoPairData = JSON.parse(data);
        let videoPairDiv = document.getElementById("videoPair");
        videoPairDiv.innerHTML = "";
        videoPairDiv.appendChild(generateSingleVideo(videoPairData, 0));
        videoPairDiv.appendChild(generateSingleVideo(videoPairData, 1));
    })
}

