
package software.xdev.swagger_rapidclipse;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.PWA;


@PWA(name = "Swagger_RapidClipse", shortName = "Swagger_RapidClipse")
public class AppShell implements AppShellConfigurator
{
	@Override
	public void configurePage(final AppShellSettings settings)
	{
		settings.addFavIcon("icon", "frontend/images/favicon256.png", "256x256");
		settings.addLink("shortcut icon", "frontend/images/favicon.ico");
	}
}
