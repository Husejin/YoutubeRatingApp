async function deleteVideo(videoId) {
    $.post("http://localhost:9090/Backend_war_exploded/deleteSingleVideo",
        {id: videoId});
}

export default function deleteVideoHandler(event) {
    if (confirm("Are you sure you want to delete this video?")) {
        let videoId = event.target.parentNode.parentElement.getAttribute('id');
        deleteVideo(videoId);
        location.reload();
    }
}