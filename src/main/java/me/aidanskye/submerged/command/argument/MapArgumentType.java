package me.aidanskye.submerged.command.argument;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import me.aidanskye.submerged.Submerged;
import me.aidanskye.submerged.maps.SubmergedMap;
import me.aidanskye.submerged.maps.SubmergedMaps;
import net.minecraft.command.CommandSource;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapArgumentType implements ArgumentType<Identifier> {
    private static final Collection<String> EXAMPLES = Stream.of(Submerged.id("yacht"), Submerged.id("clue"), Submerged.id("office"))
            .map(Object::toString)
            .collect(Collectors.toList());
    private static final DynamicCommandExceptionType INVALID_MAP_EXCEPTION = new DynamicCommandExceptionType(
            id -> Text.stringifiedTranslatable("submerged.argument.map.invalid", id)
    );

    public Identifier parse(StringReader stringReader) throws CommandSyntaxException {
        return Identifier.fromCommandInput(stringReader);
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return context.getSource() instanceof CommandSource
                ? CommandSource.suggestIdentifiers(SubmergedMaps.MAPS.keySet().stream().toList(), builder)
                : Suggestions.empty();
    }

    @Override
    public Collection<String> getExamples() {
        return EXAMPLES;
    }

    public static MapArgumentType map() {
        return new MapArgumentType();
    }

    public static SubmergedMap getMapArgument(CommandContext<ServerCommandSource> context, String name) throws CommandSyntaxException {
        Identifier identifier = context.getArgument(name, Identifier.class);
        SubmergedMap map = SubmergedMaps.MAPS.get(identifier);
        if (map == null) {
            throw INVALID_MAP_EXCEPTION.create(identifier);
        } else {
            return map;
        }
    }
}
