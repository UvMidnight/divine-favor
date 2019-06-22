package aurocosh.divinefavor.common.network.message.sever.talisman_properties

class MessageSyncTalismanPropertyBool : MessageSyncTalismanProperty<Boolean> {
    override var value: Boolean = false

    constructor()

    constructor(itemId: Int, name: String, value: Boolean) : super(itemId, name) {
        this.value = value
    }
}