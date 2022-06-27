function createVideo(videoInfo) {
    $.post("http://localhost:9090/Backend_war_exploded/createVideo",
        {videoInfo: JSON.stringify(videoInfo)});
}

export default function initialize() {
    initializeCreateHandler();
    initializeImageHandler();
}

function initializeCreateHandler() {
    let createButton = document.getElementById('createButton');
    let nameInput = document.getElementById('name');
    let urlInput = document.getElementById('url');
    let thumbnailUrlInput = document.getElementById('thumbnailUrl');
    let imageInput = document.getElementById('image');
    let videoInfo = {};
    createButton.onclick = (event) => {
        if (nameInput.value !== "" && urlInput.value !== "" && (thumbnailUrlInput.value !== "" || imageInput.value !== "")) {
            videoInfo.name = nameInput.value;
            videoInfo.url = urlInput.value;
            videoInfo.thumbnailUrl = thumbnailUrlInput.value;
            if (imageInput.files && imageInput.files[0]) {

                createVideoWithAlternateImage(imageInput, videoInfo);
            } else {

                createVideo(videoInfo);
                alert("Video successfully created! ");
            }
            location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/adminHome.html`);
        } else {
            alert("Please fill out all the fields!");
        }
    }
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

function createVideoWithAlternateImage(input, videoInfo) {

    var reader = new FileReader();
    reader.onload = function (e) {
        videoInfo.alternateImage = e.target.result.substring(e.target.result.indexOf(',')+1);
        createVideo(videoInfo);
        alert("Video successfully created! ");
    };
    reader.readAsDataURL(input.files[0]);

}

