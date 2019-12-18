package com.infoshareacademy.Language;

public enum LangKeyConfig {


    DATABASE_LOADED("the_book_database_has_been_loaded"),
    AVAILABLE_BOOKS("available_books"),
    MAIN_MENU_POSITION("main_menu"),
    SHOW_ALL_ITEMS("show_all_items"),
    DISPLAY_ONE_ITEM("display_one_item"),
    SEARCH_BY_AUTHOR("search_by_author"),
    SEARCH_BY_TITLE("search_by_title"),
    CONSOLE_OUT("CONSOLE_OUT"),
    WELCOME("welcome_to_the_main_page_of_the_for_plus_one"),
    YOU_CAN_CHOOSE("you_can_choose"),
    SEARCH_BY_AUTHOR_AND_TITLE("search_by_author_and_title_of_the_book"),
    RETURN_TO_PREVIOUS_MENU("return_to_previous_menu"),
    SELECT_THE_OPTION_NUMBER_FROM_MENU("select_the_option_number_from_the_menu"),
    TITLE("title"),
    LITERARY_TYPE_BOOK("literary_type_of_book"),
    AUTHOR("author"),
    EPOCH("epoch"),
    HAS_AUDIO("has_the_audio_option"),
    GENRE ("genre"),
    NO_FILE("no_file"),
    FILE_READING_ERROR("file_reading_error"),
    DATABASE_NOT_READ_FROM_FILE("database_not_read_from_file"),
    HOW_MANY_RECORDS_PER_PAGE("how_many_records_per_page"),
    TYPE_Q_IF_YOU_WANT_TO_LIVE("type_q_if_you_want_to_leave_the_list_any_character_will_continue_to_display"),
    PRESS_ENTER_TO_CONTINUE("press_enter_to_continue"),
    ENTER_BOOK_NUMBER("enter_the_book_number"),
    INCORRECT_SELECTION_TRY_AGAIN("incorrect_selection_try_again"),
    SELECT("select"),
    LOAD_JSON_FROM_FILE_AGAIN("1_load_the_json_file_again"),
    EXIT_FROM_APPLICATION("2_exit_the_application"),
    SEE_YOU("see_you_later"),
    INCORRECT_SELECTION("incorrect_selection"),
    SCREEN_CLEANING_FAILED("screen_cleaning_failed"),
    WRONG_INPUT_TRY_AGAIN("you_have_typed_incorrectly_try_again"),
    PLEASE_CHOOSE_ONE_OF("please_choose_one_of");



















    private String value;

    LangKeyConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
