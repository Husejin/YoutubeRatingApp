import {getCookie, setCookie} from "./cookieService.js";

export default function registerLoginHandler() {
    let signInButton = document.getElementById('signInButton');
    signInButton.onclick = loginHandler;
}

async function checkUserLogin(username, password, callback) {
    $.get("http://localhost:9090/Backend_war_exploded/login",
        {username: username, password: password}, callback);
}

function loginHandler() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    checkUserLogin(username, password, loginRequestCallback);
}

function loginRequestCallback(data) {
    let loginResponse = JSON.parse(data);
    console.log(loginResponse);
    if (loginResponse.status === 'SUCCESS') {
        if (loginResponse.role === 'ADMIN') {
            alert("You logged in as admin user. We are redirecting you to the admin page now.");
            setCookie('LOGGED', 'ADMIN');
            location.href = "admin/adminHome.html"
        } else {
            location.href = "app.html";
        }
    } else {
        alert("Your username/password is incorrect");
    }
}

export function checkLoggedAdminStatus() {
    if (getCookie('LOGGED')==='ADMIN') {
        location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/adminHome.html`);
    }
    else if(getCookie('LOGGED'))
    {
        location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/app.html`)
    }
}
export function checkAdminStatus()
{
    if (getCookie('LOGGED')!=='ADMIN') {
        location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/app.html`);
    }
}


