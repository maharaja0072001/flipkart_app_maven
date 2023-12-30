package org.abc.launcher;

import org.abc.authentication.view.AuthenticationView;
import org.abc.view.homepage.HomepageView;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * <p>
 * Launches the flipkart application.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class Launcher {

    private static final Logger LOGGER = LogManager.getLogger(Launcher.class);

    /**
     * <p>
     * The main entry to the flipkart application.
     * </p>
     *
     * @param arguments Refers command line arguments to flipkart application
     */
    public static void main(final String[] arguments) {
        LOGGER.info("Flipkart application started");
        final AuthenticationView authenticationView = AuthenticationView.getInstance();

        authenticationView.setHomePageView(HomepageView.getInstance());
        authenticationView.showAuthenticationPage();
    }
}
