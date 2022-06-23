import {generateRankingPageVideos} from "../services/rankingServices/rankedVIdeosService.js";
import generatePageNavigationButtons from "../services/rankingServices/generateNavigationLinksService.js";
let pageIndex = 0;
generateRankingPageVideos(pageIndex);
generatePageNavigationButtons(pageIndex);
