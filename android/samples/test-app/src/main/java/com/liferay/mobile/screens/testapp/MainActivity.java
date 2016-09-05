package com.liferay.mobile.screens.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.liferay.mobile.screens.cache.Cache;
import com.liferay.mobile.screens.ddl.form.interactor.DDLFormEvent;
import com.liferay.mobile.screens.testapp.fullview.LoginFullActivity;
import com.liferay.mobile.screens.viewsets.defaultviews.DefaultAnimation;

/**
 * @author Silvio Santos
 */
public class MainActivity extends ThemeActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle state) {
		super.onCreate(state);
		setContentView(R.layout.activity_main);

		findViewById(R.id.ddl_form).setOnClickListener(this);
		findViewById(R.id.ddl_list).setOnClickListener(this);
		findViewById(R.id.asset_list).setOnClickListener(this);
		findViewById(R.id.web_content_list).setOnClickListener(this);
		findViewById(R.id.sign_up).setOnClickListener(this);
		findViewById(R.id.forgot_password).setOnClickListener(this);
		findViewById(R.id.user_portrait).setOnClickListener(this);
		findViewById(R.id.web_content_display_screenlet).setOnClickListener(this);
		findViewById(R.id.web_content_display_screenlet_structured).setOnClickListener(this);
		findViewById(R.id.add_bookmark).setOnClickListener(this);
		findViewById(R.id.journal_article_with_template).setOnClickListener(this);
		findViewById(R.id.filtered_asset).setOnClickListener(this);
		findViewById(R.id.login_full_screenlet).setOnClickListener(this);
		findViewById(R.id.change_theme).setOnClickListener(this);
		findViewById(R.id.login).setOnClickListener(this);
		findViewById(R.id.clear_cache).setOnClickListener(this);
		findViewById(R.id.clear_cache_forms).setOnClickListener(this);
		findViewById(R.id.sync_cache).setOnClickListener(this);
		findViewById(R.id.custom_interactor).setOnClickListener(this);
		findViewById(R.id.list_bookmarks).setOnClickListener(this);
		findViewById(R.id.relogin).setOnClickListener(this);
		findViewById(R.id.list_comments).setOnClickListener(this);
		findViewById(R.id.ratings).setOnClickListener(this);
		findViewById(R.id.user_display).setOnClickListener(this);
		findViewById(R.id.gallery).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.ddl_form:
				start(DDLFormActivity.class);
				break;
			case R.id.ddl_list:
				start(DDLListActivity.class);
				break;
			case R.id.asset_list:
				start(SelectAssetActivity.class);
				break;
			case R.id.web_content_list:
				start(WebViewListActivity.class);
				break;
			case R.id.sign_up:
				start(SignUpActivity.class);
				break;
			case R.id.forgot_password:
				start(ForgotPasswordActivity.class);
				break;
			case R.id.user_portrait:
				start(UserPortraitActivity.class);
				break;
			case R.id.web_content_display_screenlet:
				start(WebContentDisplayActivity.class);
				break;
			case R.id.web_content_display_screenlet_structured:
				start(WebContentDisplayStructuredActivity.class);
				break;
			case R.id.add_bookmark:
				start(AddBookmarkActivity.class);
				break;
			case R.id.journal_article_with_template:
				start(JournalArticleWithTemplateActivity.class);
				break;
			case R.id.filtered_asset:
				start(FilteredAssetActivity.class);
				break;
			case R.id.login_full_screenlet:
				start(LoginFullActivity.class);
				break;
			case R.id.change_theme:
				finish();
				changeToNextTheme();
				start(MainActivity.class);
				break;
			case R.id.clear_cache_forms:
				boolean destroyed = Cache.destroy(DDLFormEvent.class.getSimpleName());
				info("Deleted DDLFormEvent cache entries: " + (destroyed ? "successfully" : "failed"));
				break;
			case R.id.clear_cache:
				boolean success = Cache.destroy();
				info("Cache cleared: " + (success ? "successfully" : "failed"));
				break;
			case R.id.sync_cache:
				Cache.resync();
				info("Launched resync process");
				break;
			case R.id.custom_interactor:
				start(CustomInteractorActivity.class);
				break;
			case R.id.list_bookmarks:
				start(ListBookmarksActivity.class);
				break;
			case R.id.relogin:
				start(ReloginActivity.class);
				break;
			case R.id.list_comments:
				start(CommentsActivity.class);
				break;
			case R.id.ratings:
				start(RatingsActivity.class);
				break;
			case R.id.gallery:
				start(GalleryActivity.class);
				break;
			case R.id.user_display:
				Intent intent = getIntentWithTheme(AssetDisplayActivity.class);
				intent.putExtra("entryId", Long.valueOf(getResources().getString(R.string.liferay_user_entryId)));
				DefaultAnimation.startActivityWithAnimation(this, intent);
				break;
			default:
				start(LoginActivity.class);
		}
	}

	private void start(Class clasz) {
		DefaultAnimation.startActivityWithAnimation(this, getIntentWithTheme(clasz));
	}
}