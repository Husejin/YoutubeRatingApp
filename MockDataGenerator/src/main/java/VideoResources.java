public class VideoResources {
    private static String[] videoUrls = new String[]{"https://www.youtube.com/embed/jAOIwNOU_I4", "https://www.youtube.com/embed/GtnTCjsQXB8", "https://www.youtube.com/embed/XB7Lzt_stNY", "https://www.youtube.com/embed/-1MOXM9GBFk", "https://www.youtube.com/embed/hapMSHVF2ks", "https://www.youtube.com/embed/h9Zv_TiVzmg", "https://www.youtube.com/embed/UjZYMI1zB9s", "https://www.youtube.com/embed/Bv4CqIxqTMA", "https://www.youtube.com/embed/jJApnB-Kf4M", "https://www.youtube.com/embed/4RlYKWPDPhA"};
    private static String[] videoThumbnails = new String[]{"https://img.youtube.com/vi/jAOIwNOU_I4/hqdefault.jpg", "https://img.youtube.com/vi/GtnTCjsQXB8/hqdefault.jpg", "https://img.youtube.com/vi/XB7Lzt_stNY/hqdefault.jpg", "https://img.youtube.com/vi/-1MOXM9GBFk/hqdefault.jpg", "https://img.youtube.com/vi/hapMSHVF2ks/hqdefault.jpg", "https://img.youtube.com/vi/h9Zv_TiVzmg/hqdefault.jpg", "https://img.youtube.com/vi/UjZYMI1zB9s/hqdefault.jpg", "https://img.youtube.com/vi/Bv4CqIxqTMA/hqdefault.jpg", "https://img.youtube.com/vi/jJApnB-Kf4M/hqdefault.jpg", "https://img.youtube.com/vi/4RlYKWPDPhA/hqdefault.jpg"};
    private static String[] videoTitles = new String[]{"ESL - ESPORTS PROMOTION VIDEO", "G2 Worlds 2019 Hype video", "STAY HUNGRY - Esports Motivation", "Inspire - A CS:GO motivational video by Zelli0n", "Rocket League: The Greatest Esport Of All Time (Documentary)", "The Story of Dota 2", "Free to Play", "True Sight : The International 2018 Finals", "The Story Of World of Warcraft", "WoW esports Gladiator’s Summit: Episode One"};

    public static String getRandomVideoURL(int index) {
        return videoUrls[index];
    }

    public static String getRandomVideoThumbnailUrl(int index) {
        return videoThumbnails[index];
    }

    public static String getRandomVideoTitle(int index) {
        return videoTitles[index];
    }

}
