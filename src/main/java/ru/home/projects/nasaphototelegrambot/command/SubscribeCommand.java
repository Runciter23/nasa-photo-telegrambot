package ru.home.projects.nasaphototelegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.home.projects.nasaphototelegrambot.service.SendBotMessageService;
import ru.home.projects.nasaphototelegrambot.utils.AnswerMessage;

import java.util.List;

public class SubscribeCommand implements Command {

    private final SendBotMessageService messageService;

    public SubscribeCommand(SendBotMessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void execute(Update update) {
        InlineKeyboardMarkup inlineKeyboardMarkup = getInlineKeyboardMarkup();
        messageService.sendMessage(update.getMessage().getChatId().toString(), AnswerMessage.SUBSCRIBE_COMMAND, inlineKeyboardMarkup);
    }

    private InlineKeyboardMarkup getInlineKeyboardMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = List.of(
                List.of(InlineKeyboardButton.builder()
                                .text("Подписаться")
                                .callbackData("subscribe")
                                .build(),
                        InlineKeyboardButton.builder()
                                .text("Отменить подписку")
                                .callbackData("unsubscribe")
                                .build())
        );
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
}
