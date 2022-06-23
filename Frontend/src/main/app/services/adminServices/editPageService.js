import {fetchSpecificVideo} from "../videoServies/generateSingleVideoService.js";

export default function initialize() {
    let urlParams = new URLSearchParams(window.location.search);
    let videoId = urlParams.get('id');
    fetchSpecificVideo(videoId, initializeInputs);
}

function initializeInputs(videoData) {
    let videoInfo = JSON.parse(videoData);
    let nameInput = document.getElementById('name');
    let urlInput = document.getElementById('url');
    let thumbnailUrlInput = document.getElementById('thumbnailUrl');
    let imageInput = document.getElementById('image');

    nameInput.value = videoInfo.name;
    urlInput.value = videoInfo.url;
    thumbnailUrlInput.value = videoInfo.thumbnailUrl;
    initializeUpdateHandler(videoInfo);

}

function initializeUpdateHandler(videoInfo){
    let updateButton = document.getElementById('updateButton');
    let nameInput = document.getElementById('name');
    let urlInput = document.getElementById('url');
    let thumbnailUrlInput = document.getElementById('thumbnailUrl');
    let imageInput = document.getElementById('image');
    updateButton.onclick=(event)=>{
        videoInfo.name=nameInput.value;
        videoInfo.url=urlInput.value;
        videoInfo.thumbnailUrl = thumbnailUrlInput.value;
        updateVideo(videoInfo);
        alert("Video successfully updated!");
        location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/adminHome.html`);
    }
}

function updateVideo(videoInfo) {
    $.post("http://localhost:9090/Backend_war_exploded/updateSpecificVideo",
        {videoInfo: JSON.stringify(videoInfo)}, (data)=>{console.log(data)});
}



