package session34.tank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TankConfiguration {
    @Bean
    public Tank t34() {
        return new Chassis(new Caliber76Cannon(), new ManualShellLoader());
    }

    @Bean
    public Tank futureTank(Cannon photoCannon, ShellLoader autoLoader) {
        return new Chassis(photoCannon, autoLoader);
    }

    @Bean
    @Scope("prototype")
    Cannon photoCannon() {
        return new PhotoCannon();
    }

    @Bean
    @Scope("prototype")
    ShellLoader autoLoader() {
        return new AutoShellLoader();
    }
}
