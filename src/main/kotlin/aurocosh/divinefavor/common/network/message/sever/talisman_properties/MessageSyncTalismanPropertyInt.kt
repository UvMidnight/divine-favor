package aurocosh.divinefavor.common.network.message.sever.talisman_properties

class MessageSyncTalismanPropertyInt : MessageSyncTalismanProperty<Int> {
    override var value: Int = 0

    constructor()

    constructor(itemId: Int, name: String, value: Int) : super(itemId, name) {
        this.value = value
    }
}