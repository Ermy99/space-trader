package cs2340.spacetraders.Model

import java.io.Serializable

/**
 * TechLevel.kt
 * Enum of tech levels for the solar systems.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
enum class TechLevel private constructor(//7

        private val TechLevel: String) {

    PREAGRICULTURAL("Pre-Agricultural"), //0
    AGRICULTURAL("Agricultural"), //1
    MEDIEVAL("Medieval"), //2
    RENAISSANCE("Renaissance"), //3
    EARLY_INDUSTRIAL("Early Industrial"), //4
    INDUSTRIAL("Industrial"), //5
    POST_INDUSTRIAL("Post-Industrial"), //6
    HI_TECH("Hi-Tech");

    override fun toString(): String {
        return TechLevel
    }

}