package api.Parameters;

import api.ValueObject.Model.LoginViewModel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CreateAndAddBooksParameters implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(new LoginViewModel("Barber", "Qwerty@1234")),
                Arguments.of(new LoginViewModel("Barista", "Qwerty@1234")),
                Arguments.of(new LoginViewModel("Barmen", "Qwerty@1234"))
        );
    }
}
