import {fetchSpecificVideo} from "../videoServies/generateSingleVideoService.js";


export default function initialize() {
    let urlParams = new URLSearchParams(window.location.search);
    let videoId = urlParams.get('id');
    fetchSpecificVideo(videoId, initializeInputs);
    initializeImageHandler();
}

function initializeInputs(videoData) {
    let videoInfo = JSON.parse(videoData);
    let nameInput = document.getElementById('name');
    let urlInput = document.getElementById('url');
    let thumbnailUrlInput = document.getElementById('thumbnailUrl');
    let imageInput = document.getElementById('image');
    let alternateImage = document.getElementById('alternateImage');
    nameInput.value = videoInfo.name;
    urlInput.value = videoInfo.url;
    thumbnailUrlInput.value = videoInfo.thumbnailUrl;
    if (videoInfo.alternateImage) {
        alternateImage.src = (videoInfo.alternateImage) ?  `data:image/png;base64,${videoInfo.alternateImage}` :  videoInfo.thumbnailUrl;;
    }
    initializeUpdateHandler(videoInfo);

}

function initializeUpdateHandler(videoInfo) {
    let updateButton = document.getElementById('updateButton');
    let nameInput = document.getElementById('name');
    let urlInput = document.getElementById('url');
    let thumbnailUrlInput = document.getElementById('thumbnailUrl');
    let imageInput = document.getElementById('image');
    updateButton.onclick = (event) => {
        videoInfo.name = nameInput.value;
        videoInfo.url = urlInput.value;
        videoInfo.thumbnailUrl = thumbnailUrlInput.value;
        if (imageInput && imageInput.files[0]) {
            console.log(videoInfo);
        updateVideoWithAlternateImage(imageInput,videoInfo);
        } else {
            console.log(videoInfo);
            updateVideo(videoInfo);
            alert("Video successfully updated! ");
        }
        location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/adminHome.html`);
    }
}

function updateVideo(videoInfo) {
    $.post("http://localhost:9090/Backend_war_exploded/updateSpecificVideo",
        {videoInfo: JSON.stringify(videoInfo)}, (data) => {
            console.log(data)
        });
}
function updateVideoWithAlternateImage(input, videoInfo)
{
    var reader = new FileReader();
    reader.onload = function (e) {
        videoInfo.alternateImage = e.target.result.substring(e.target.result.indexOf(',')+1);
        updateVideo(videoInfo);
        alert("Video successfully updated! ");
    };
    reader.readAsDataURL(input.files[0]);
}

 function initializeImageHandler() {
    let imageInput = document.getElementById('image');
    imageInput.onchange = (event) => {
        readURL(imageInput)
    };
}


function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#alternateImage').attr('src', e.target.result).width(150).height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }
}



