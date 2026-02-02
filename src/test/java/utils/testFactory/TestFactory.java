package utils.testFactory;

import org.testng.annotations.Factory;

// Authentication
import testClasses.features.Authentication.WelcomeScreenTest;
import testClasses.features.Authentication.RegisterTest;
import testClasses.features.Authentication.LoginTests;
import testClasses.features.Authentication.ForgotPasswordTest;
import testClasses.features.Authentication.ResetPasswordTest;

// Badge
import testClasses.features.Badge.BadgeTest;

// Communities
import testClasses.features.Communities.SearchAboutCommunitiesTest;
import testClasses.features.Communities.CreationCommunityTest;
import testClasses.features.Communities.ModeratorCommunityTest;

// Donation
import testClasses.features.Donation.EasyGiveTest;
import testClasses.features.Donation.SingleDonationTest;

// Givers
import testClasses.features.Givers.*;

// Needy
import testClasses.features.Needy.*;

// Notifications
import testClasses.features.Notifications.NotificationTest;

public class TestFactory {

    @Factory
    public Object[] androidRegressionSuite() {

        if (!"Android".equalsIgnoreCase(System.getProperty("platform"))) {
            return new Object[]{};
        }

        return new Object[]{

                // 1️⃣ Authentication (ordered)
                new WelcomeScreenTest(),
                new RegisterTest(),
                new LoginTests(),
                new ForgotPasswordTest(),
                new ResetPasswordTest(),

                // 2️⃣ Badge
                new BadgeTest(),

                // 3️⃣ Communities
                new SearchAboutCommunitiesTest(),
                new CreationCommunityTest(),
                new ModeratorCommunityTest(),

                // 4️⃣ Donation
                new EasyGiveTest(),
                new SingleDonationTest(),

                // 5️⃣ Givers
                new AboutGiversTest(),
                new ApplicationFeedbackTest(),
                new JoinAsNGOTest(),
                new MyFavoritesTest(),
                new PersonalInformationTest(),

                // 6️⃣ Needy
                new CreateNeedyProfileTest(),
                new NeedyCheckTest(),
                new NeedyFunctionsTest(),

                // 7️⃣ Notifications
                new NotificationTest(),
                new DeleteAccountTest()
        };
    }
}
