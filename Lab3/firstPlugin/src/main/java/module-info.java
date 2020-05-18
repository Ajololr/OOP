import sample.IService;

module firstPlugin {
    requires core;

    provides IService with NewCard.NewCard;
}