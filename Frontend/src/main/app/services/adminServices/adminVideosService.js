import generateAdminTableRow from "./generateAdminTableRowService.js";
let currentPage=0;

async function fetchRankedVideos(limit, offset, callback, pageIndex) {
    currentPage=pageIndex;
    $.get("http://localhost:9090/Backend_war_exploded/generateRankedVideos",
        {limit: limit, offset: offset}, callback);
}

function generateVideoRows(data) {
    let topVideos = JSON.parse(data);
    let rankBodyDiv = document.getElementById("topVideos");
    rankBodyDiv.innerHTML = "";
    if (topVideos.length !== 0) {
        for (let i = 0; i < topVideos.length; i++) {
            rankBodyDiv.appendChild(generateAdminTableRow(topVideos[i], i, currentPage));
        }
    } else
        rankBodyDiv.innerHTML = "<span style='display: flex; align-items: center; flex-direction: column;'>No more results!</span>";
}

export function generateRankingPageVideos(pageIndex) {
    fetchRankedVideos(20, pageIndex * 20, generateVideoRows, pageIndex);
    //pomocu page index varijable koju koristimo kroz ranking page mozemo izracunati limit i offset koji nam treba za svaki zaseban page
    // kako bi svaki
    //put kad dohvatimo listu videa iz baze dobili tacno 20 videa..
    //takodjer listu videa dohvatamo tek na klik dugmeta da predjemo na sledeci page
    //S tim u vidim mislim da ne bi trebali gubiti brzinu i performanse s povecanjem broja videa u bazi.
}


