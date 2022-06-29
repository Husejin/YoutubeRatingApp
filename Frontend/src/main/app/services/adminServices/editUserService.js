
async function fetchSepcificUser(userId,callback)
{
    $.get("http://localhost:9090/Backend_war_exploded/getUser", {
        userId: userId
    }, callback)
}

export default function initialize() {
    let urlParams = new URLSearchParams(window.location.search);
    let userId = urlParams.get('id');
    fetchSepcificUser(userId, initializeInputs);

}

function initializeInputs(userData) {
    let userInfo = JSON.parse(userData);
    let usernameInput = document.getElementById('username');
    let passwordInput = document.getElementById('password');
    let roleInput = document.getElementById('role');
    usernameInput.value = userInfo.username;
    passwordInput.value = userInfo.password;
    roleInput.checked = (userInfo.role === 'ADMIN');
    initializeUpdateHandler(userInfo);

}

function initializeUpdateHandler(userInfo) {
    let updateButton = document.getElementById('updateButton');
    let usernameInput = document.getElementById('username');
    let passwordInput = document.getElementById('password');
    let roleInput = document.getElementById('role');

    updateButton.onclick = (event) => {
        userInfo.username = usernameInput.value;
        userInfo.password = passwordInput.value;
        userInfo.role = (roleInput.checked) ? 'ADMIN' : 'COMMON';
        updateUser(userInfo);
        alert("User successfully updated! ");

        location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/adminHome.html`);
    }
}

function updateUser(userInfo) {
    $.post("http://localhost:9090/Backend_war_exploded/updateUser",
        {userInfo: JSON.stringify(userInfo)}, (data) => {
            console.log(data)
        });
}

