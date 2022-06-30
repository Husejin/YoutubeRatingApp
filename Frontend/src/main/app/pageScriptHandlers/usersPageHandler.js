import {checkAdminStatus} from "../services/utilityServices/loginService.js";
import {
    generateUsersNavigationButtons,
    initializeLogoutHandler
} from "../services/adminServices/generateAdminNavigationLinksService.js";
import {generateAdminPageUsers} from "../services/adminServices/usersPageService.js";

let pageIndex = 0;
checkAdminStatus();
generateAdminPageUsers(pageIndex);
generateUsersNavigationButtons(pageIndex);
initializeLogoutHandler();