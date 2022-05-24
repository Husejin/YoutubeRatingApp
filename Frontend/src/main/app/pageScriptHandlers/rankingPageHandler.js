import {generateRankingPageVideos} from "../services/rankedVIdeosService.js";
import generatePageNavigationButtons from "../services/generateNavigationLinksService.js";
let pageIndex = 0;
generateRankingPageVideos(pageIndex);
generatePageNavigationButtons(pageIndex);
