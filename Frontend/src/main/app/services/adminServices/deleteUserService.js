export default async function deleteUser(videoId){
    $.post("http://localhost:9090/Backend_war_exploded/deleteUser",
        {userId: videoId});
}