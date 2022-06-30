import generateUserTableRow from "./generateUserTableRowService.js";

let currentPage=0;
async function fetchUsers(limit,offset,callback,pageIndex)
{
    currentPage=pageIndex;
    $.get("http://localhost:9090/Backend_war_exploded/getUsers",
        {limit: limit, offset: offset}, callback);
}

export function generateAdminPageUsers(pageIndex)
{
    fetchUsers(20,pageIndex*20,generateUserRows,pageIndex);
}

function generateUserRows(data)
{
    let allUsers = JSON.parse(data);
    let rankBodyDiv = document.getElementById("topVideos");
    rankBodyDiv.innerHTML = "";
    if (allUsers.length !== 0) {
        for (let i = 0; i < allUsers.length; i++) {
            rankBodyDiv.appendChild(generateUserTableRow(allUsers[i], i, currentPage));
        }
    } else
        rankBodyDiv.innerHTML = "<span style='display: flex; align-items: center; flex-direction: column;'>No more results!</span>";

}