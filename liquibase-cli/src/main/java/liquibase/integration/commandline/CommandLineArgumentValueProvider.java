package liquibase.integration.commandline;

import liquibase.configuration.AbstractMapConfigurationValueProvider;
import picocli.CommandLine;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class CommandLineArgumentValueProvider  extends AbstractMapConfigurationValueProvider {

    private final SortedMap<String, Object> argumentValues = new TreeMap<>();

    public CommandLineArgumentValueProvider(CommandLine.ParseResult parseResult) {
        for (CommandLine.Model.OptionSpec option : parseResult.matchedOptions()) {
            this.argumentValues.put(option.names()[0], option.getValue());
        }
    }

    @Override
    public int getPrecedence() {
        return 250;
    }

    @Override
    protected Map<?, ?> getMap() {
        return argumentValues;
    }

    @Override
    protected boolean keyMatches(String wantedKey, String storedKey) {
        return super.keyMatches(wantedKey, storedKey.replaceFirst("^--", "")) || super.keyMatches(wantedKey, "liquibase."+storedKey.replaceFirst("^--", ""));
    }

    @Override
    protected String getSourceDescription() {
        return "Command argument";
    }
}