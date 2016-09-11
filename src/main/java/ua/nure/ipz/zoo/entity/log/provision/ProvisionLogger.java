package ua.nure.ipz.zoo.entity.log.provision;

import ua.nure.ipz.zoo.entity.Provision;

//@Entity
public class ProvisionLogger extends ProvisionLog {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void log(Provision target) {
        stringBuilder.append(target + "\n");
    }

    @Override
    public String getLog() {
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getLog();
    }
}
