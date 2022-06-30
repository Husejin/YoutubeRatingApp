import {generateRankingPageVideos} from "./adminVideosService.js";
import { eraseCookie, getCookie} from "../utilityServices/cookieService.js";
import {generateAdminPageUsers} from "./usersPageService.js";

export default function generatePageNavigationButtons(pageIndex) {
    let previousPageButton = document.createElement("button");
    previousPageButton.textContent = "<";
    previousPageButton.onclick = () => {
        if (pageIndex > 0) {
            pageIndex--;
            generateRankingPageVideos(pageIndex);
        }
    }

    let nextPageButton = document.createElement("button");
    nextPageButton.textContent = ">";
    let rankBodyDiv = document.getElementById("topVideos");

    nextPageButton.onclick = () => {
        if (rankBodyDiv.textContent != "No more results!") {
            pageIndex++;
            generateRankingPageVideos(pageIndex);
        }
    }
    let pagingDiv = document.getElementById("navigationButtons");
    pagingDiv.appendChild(previousPageButton);
    pagingDiv.appendChild(nextPageButton);
}

export function generateUsersNavigationButtons(pageIndex) {
    let previousPageButton = document.createElement("button");
    previousPageButton.textContent = "<";
    previousPageButton.onclick = () => {
        if (pageIndex > 0) {
            pageIndex--;
            generateAdminPageUsers(pageIndex);
        }
    }

    let nextPageButton = document.createElement("button");
    nextPageButton.textContent = ">";
    let rankBodyDiv = document.getElementById("topVideos");

    nextPageButton.onclick = () => {
        if (rankBodyDiv.textContent != "No more results!") {
            pageIndex++;
            generateAdminPageUsers(pageIndex);
        }
    }
    let pagingDiv = document.getElementById("navigationButtons");
    pagingDiv.appendChild(previousPageButton);
    pagingDiv.appendChild(nextPageButton);
}




export function initializeLogoutHandler() {
    let logoutButton = document.getElementById('logoutButton');
    logoutButton.onclick = logoutHandler;
}

function logoutHandler() {
    if (getCookie('LOGGED')==='ADMIN') {
        eraseCookie('LOGGED');
        location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/app.html`);
    }
}