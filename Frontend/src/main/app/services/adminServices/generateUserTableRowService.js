import deleteUser from "./deleteUserService.js";


export default function generateUserTableRow(userData) {
    let tableRow = document.createElement("div");
    tableRow.className = "tableRow";
    tableRow.setAttribute("id", userData.id);
    let headerHeadLine = document.createElement("div");
    headerHeadLine.className = "headerHeadline";
    let headlineInfo = document.createElement("div");
    headlineInfo.className = "headlineInfo";

    let username = document.createElement("div");
    username.className = "songTitle";
    username.textContent = userData.username;
    headlineInfo.appendChild(username);
    headerHeadLine.appendChild(headlineInfo);
    let headerVotes = document.createElement("div");
    headerVotes.className = "headerVotes";
    let password = document.createElement("div");
    password.className = "headlineInfo";
    password.textContent = userData.password;
    headerVotes.appendChild(password);
    let headerRank = document.createElement("div");
    headerRank.className = "headerVotes";
    let role = document.createElement("div");
    role.className = "headlineInfo";
    role.textContent = userData.role;
    let editUser = document.createElement("div");
    editUser.className = "editCog";
    let editIcon = document.createElement("i");
    editIcon.className = "fa fa-cog";
    editUser.appendChild(editIcon);
    editUser.onclick = editUserHandler;

    let deleteUser = document.createElement("div");
    deleteUser.className = "editCog";
    let deleteIcon = document.createElement("i");
    deleteIcon.className = "fa fa-trash";
    deleteUser.appendChild(deleteIcon);
    deleteUser.onclick = deleteUserHandler;

    headerRank.appendChild(role);
    tableRow.appendChild(headerHeadLine);
    tableRow.appendChild(headerVotes);
    tableRow.appendChild(headerRank);
    tableRow.appendChild(editUser);
    tableRow.appendChild(deleteUser);

    return tableRow;
}

function editUserHandler(event){
    let userId = event.target.parentNode.parentElement.getAttribute('id');
    location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/editUser.html?id=${userId}`);
}

function deleteUserHandler(event){
    if (confirm("Are you sure you want to delete this user?")) {
        let videoId = event.target.parentNode.parentElement.getAttribute('id');
        deleteUser(videoId);
        location.reload();
    }
}