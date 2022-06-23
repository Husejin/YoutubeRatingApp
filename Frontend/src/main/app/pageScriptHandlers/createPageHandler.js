import initialize from "../services/adminServices/createPageService.js";
import {checkAdminStatus} from "../services/utilityServices/loginService.js";

checkAdminStatus();
initialize();