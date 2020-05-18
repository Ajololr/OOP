import fool.cards.FoolCard;
import sample.IService;

module secondPlugin {
    requires core;

    provides IService with FoolCard;
}