package ua.nure.ipz.zoo.entity.log.provision;

import ua.nure.ipz.zoo.entity.food.Provision;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class ProvisionLogger extends ProvisionLog {
    @Lob
    private String log;

    @Override
    public void log(Provision target) {
        log += target + "\n";
    }

    @Override
    public String getLog() {
        return log;
    }

    @Override
    public String toString() {
        return getLog();
    }
}
