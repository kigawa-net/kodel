package net.kigawa.kodel.domain.entrypoint

interface EntrypointNode<in I, out O, C> {

    /**
     * エントリーポイントにアクセスする。
     *
     * @param input 入力
     * @return 出力
     */
    fun access(input: I, ctx: C): O?
    fun flat(): List<FlattedEntrypoint<I, O, C>>
}
