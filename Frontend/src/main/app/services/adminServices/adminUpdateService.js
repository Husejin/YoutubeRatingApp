export default function editVideoHandler(event) {
    let videoId = event.target.parentNode.parentElement.getAttribute('id');
    location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/editVideo.html?id=${videoId}`);
}