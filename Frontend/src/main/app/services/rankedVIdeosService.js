import generateRankTableRow from "./generateRankTableRowService.js";
let currentPage;

async function fetchRankedVideos(limit, offset, callback, pageIndex) {
    currentPage=pageIndex;
    $.get("http://localhost:9090/Backend_war_exploded/generateRankedVideos",
        {limit: limit, offset: offset}, callback);
}

function generateVideoRows(data) {
    let topVideos = JSON.parse(data);
    let rankBodyDiv = document.getElementById("topVideos");
    rankBodyDiv.innerHTML = "";
    if (topVideos.length != 0) {
        for (let i = 0; i < topVideos.length; i++) {
            rankBodyDiv.appendChild(generateRankTableRow(topVideos[i], i, currentPage));
        }
    } else
        rankBodyDiv.innerHTML = "<span style='display: flex; align-items: center; flex-direction: column;'>No more results!</span>";
}


export default function generateTop5Videos() {
    fetchRankedVideos(5, 0, generateVideoRows);
}

export function generateRankingPageVideos(pageIndex) {
    fetchRankedVideos(20, pageIndex * 20, generateVideoRows, pageIndex);
}


