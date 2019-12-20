package com.infoshareacademy.Language;

public enum LangKeyConfig {

    DATABASE_LOADED("the_book_database_has_been_loaded"),
    AVAILABLE_BOOKS("available_books"),
    MAIN_MENU_POSITION("main_menu"),
    SHOW_ALL_ITEMS("show_all_items"),
    DISPLAY_ONE_ITEM("display_one_item"),
    SEARCH_BY_AUTHOR("search_by_author"),
    SEARCH_BY_TITLE("search_by_title"),
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
    PLEASE_CHOOSE_ONE_OF("please_choose_one_of"),
    YES("yes"),
    NO("no"),
    YOU_SELECTED("you_selected"),
    SEARCHING_FOR_BOOKS_BY_AUTHOR("searching_for_books_by_the_author_by_entering_a_string_of_characters_that_contains_name_or_surname"),
    SEARCHING_BOOKS_TITLE("searching_for_books_by_title_giving_the_string_of_characters_contained_in_the_title"),
    IN_THE_TITLE___("in_the_title_followed_by_a_string_containing_the_author_name_or_surname"),
    ENTER_AT_LEAST_3_CHAR("enter_at_least_3_characters_of_letters"),
    NO_MACHING_RES("no_matching_records_found_please_try_again"),
    MAHING_AUTOR_FOUND("matching_authors_found"),
    REFINE_YOUR_SELECTION("refine_your_selection"),
    DID_YOU_MEAN_YES("did_you_mean_yes"),
    TRY_AGAIN("try_again"),
    THERE_ARE_NO_BOOKS("there_are_no_books_matching_your_criteria"),
    LIST_OF_FAV_IS_FULL("the_list_of_favorites_is_full"),
    ITEM("item"),
    IS_IN_FAV("is_already_in_favorites"),
    REMOVED("removed"),
    ENTER_ID_BOOK("enter_the_id_of_the_book"),
    TYPED_INCORRECT_TRY_AGAIN("you_typed_incorrectly_try_again"),
    NO_BOOK_THIS_ID("there_is_no_book_with_this_id"),
    CHOSEN_BOOK("the_book_you_choose_is"),
    WHAT_TO_EDIT("what_do_you_want_to_edit"),
    EXIT("exit"),
    PROVIDED_AUTHOR("provide_author"),
    PROV_TITLE("provide_title"),
    PROV_KIND("provide_kind"),
    PROV_GENRE("provide_genre"),
    PROV_AUDIO("provide_version_audio_y_n"),
    PROV_EPOCH("provide_epoch"),
    YOU_ENTER_INCORRECT("you_entered_incorrectly"),
    Y("y"),
    N("n"),
    ID_OF_BOOK_TO_DELETE("enter_the_id_of_the_book_you_want_to_delete"),
    SEARCH_BY_BOOK_AND_AUTHOR("search_for_books_by_author_and_title_by_first_entering_the_string_of_characters_with_contains"),
    KIND("kind"),
    NOW_TITLE("now_title"),
    SURE_TO_DEL("sure_to_deleted"),
    DELETED("book_deleted"),
    ADD_BOOK("add_book"),
    SAVE_TO_FILE("save_file"),
    DELETE_BOOK("delete_book"),
    EDIT_BOOK("edit_book"),
    DATABASE_SAVED("database_saved"),
    COULDNT_SAVE("save_problem"),
    EPOCH_CHANGED("epoch_has_changed"),
    GENRE_CHANGED("genre_has_changed"),
   KIND_CHANGED ("kind_has_changed"),
    TITLE_CHANGED("title_has_changed"),
    AUTHOR_CHANGED("autor_has_changed"),
    AUDIO_CHANGED("audio_has_changed"),
    AUT("aut"),
    TIT("tit"),
    KIN("kin"),
    GEN("gen"),
    AUD("aud"),
    EPO("epo"),
    EXI("exi"),
    PRESS_L_TO_CHANGE_LANGUAGE("to_change_language_to_english_enter_l_or_L");







    private String value;

    LangKeyConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
