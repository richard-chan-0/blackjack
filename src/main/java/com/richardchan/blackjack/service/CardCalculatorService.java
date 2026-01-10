package com.richardchan.blackjack.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.richardchan.blackjack.model.FaceCard;

@Service
public class CardCalculatorService {
    private Logger logger = LoggerFactory.getLogger(CardCalculatorService.class);

    private int getCardValue(String card, int total) {
        if (FaceCard.isFaceCard(card)) {
            return FaceCard.getFaceCardValue();
        } else if (card.equals("A")) {
            int aceValue = total + 11 >= 21 ? 1 : 11;
            return aceValue;
        } else {
            return 0;
        }
    }

    public int calculateCardValues(List<String> cards) {
        logger.info("calculating cards total...");
        int total = 0;
        for (String card : cards) {
            String cardValue = card.substring(0, 1);
            logger.info(String.format("getting card value for %s", cardValue));
            total += getCardValue(cardValue, total);
        }
        return total;
    }
}
