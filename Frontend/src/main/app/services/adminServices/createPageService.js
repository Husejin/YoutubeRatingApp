function createVideo(videoInfo) {
    $.post("http://localhost:9090/Backend_war_exploded/createVideo",
        {videoInfo: JSON.stringify(videoInfo)});
}

export default function initialize() {
initializeCreateHandler();
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
            createVideo(videoInfo);
            alert("Video successfully created! ");
            location.replace(`/YoutubeRatingApp/Frontend/src/main/app/pageViews/admin/adminHome.html`);
        } else {
            alert("Please fill out all the fields!");
        }
    }
}