import {generateRankingPageVideos} from "../services/adminServices/adminVideosService.js";
import generatePageNavigationButtons, {
    initializeLogoutHandler
} from "../services/adminServices/generateAdminNavigationLinksService.js";
import {checkAdminStatus} from "../services/utilityServices/loginService.js";

let pageIndex = 0;
checkAdminStatus();
generateRankingPageVideos(pageIndex);
generatePageNavigationButtons(pageIndex);
initializeLogoutHandler();