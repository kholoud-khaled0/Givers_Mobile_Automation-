package screens.android;

import io.qameta.allure.Step;
import screens.base.CommunitiesScreen;
import utils.common.CommunityStats;
import utils.common.CommunityType;

public class AndroidCommunitiesScreen extends CommunitiesScreen {

    @Step("Open community and execute scenario based on type")
    public CommunityStats openCommunityAndExecuteScenario(
            String communityName,
            CommunityType communityType,
            String otp
    ) {

        openCommunities();
        CommunityStats stats = readCommunityStats(communityName);
        openCommunity(communityName);

        if (communityType == CommunityType.CREATED_BY_GIVERS) {
            executeCreatedByGiversScenario(stats, otp , communityName);
        }else if (communityType == CommunityType.OFFICIAL) {
            executeOfficialCommunityScenario(stats,communityName);
        }
        return stats;
    }
    @Step("Search community and verify only searched result is visible: {communityName}")
    public void searchAndVerifyOnlyResult(String communityName) {
            searchAndVerifyCommunityOnly(communityName);
}

    @Step("Execute Moderator Community Scenario")
 public void ModeratorCommunityScenario(String communityName , String giverId ,String secondEmail, String secondPassword , String email , String password ){
        executeModeratorCommunityScenario(communityName ,giverId ,secondEmail,secondPassword ,  email ,  password);
    }
}
