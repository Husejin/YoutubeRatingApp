export default function editVideoHandler(event) {
    let videoId = event.target.parentNode.parentElement.getAttribute('id');
    location.href = `/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/editVideo.html?id=${videoId}`;
}