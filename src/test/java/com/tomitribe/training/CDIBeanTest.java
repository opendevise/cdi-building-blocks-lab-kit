package com.tomitribe.training;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.Instance;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Arquillian will start the container, deploy all @Deployment bundles, then run all the @Test methods.
 *
 * A strong value-add for Arquillian is that the test is abstracted from the server.
 * It's possible to run the same test against multiple adapters or server configurations.
 *
 * A second value-add is it is possible to build archives that are slim and trim and therefore
 * isolate the functionality being tested. This also makes it easier to swap out one implementation
 * of a class for another allowing for easy mocking.
 */
@RunWith(Arquillian.class)
public class CDIBeanTest {
    /**
     * ShrinkWrap is used to create an archive (jar or war file) on the fly.
     *
     * <p>The API is quite expressive and can be used to build any custom war file.
     * It can quite easily return a import a prebuilt war file as well.</p>
     */
    @Deployment
    public static Archive createDeployment() {
        // NOTE We could also create a JavaArchive, but then a beans.xml would be required.
        return ShrinkWrap.create(WebArchive.class, "cdi-bean-test.war")
            .addClasses(LiveAndLetDie.class);
    }

    @Test
    public void testClassIsABean(Instance<LiveAndLetDie> bean) {
        assertNotNull(bean);
        LiveAndLetDie instance = bean.get();
        assertNotNull(instance);
        assertNotEquals(instance, bean.get());
    }
}