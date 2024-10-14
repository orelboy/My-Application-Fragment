package com.practicum.myapplicationfragment

// Интерфейс для управления нашим ViewPager'ом из фрагментов, которые он содержит.
interface SelectPage {

    fun navigateTo(page: Int)

}