export default function handleSocialMediaSharing()
{
    let shareButton = document.getElementById("shareButton");
    let videoPairDiv = document.getElementById("videoPair");
    shareButton.onclick=()=> {
        let currentVideoPair = videoPairDiv.children;
        let firstVideoId = currentVideoPair[0].getAttribute("id");
        let secondVideoId = currentVideoPair[1].getAttribute("id");
        navigator.clipboard.writeText(`http://localhost:63342/YoutubeRatingApp/Frontend/src/main/app/pageViews/app.html?id1=${firstVideoId}&id2=${secondVideoId}`);
        console.log(`http://localhost:63342/YoutubeRatingApp/Frontend/src/main/app/pageViews/app.html?id1=${firstVideoId}&id2=${secondVideoId}`);
        alert("Link copied to clipboard");
        }

}