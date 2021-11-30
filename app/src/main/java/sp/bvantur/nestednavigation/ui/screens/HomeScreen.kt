package sp.bvantur.nestednavigation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(parentNavController: NavHostController) {
	val scaffoldState = rememberScaffoldState()
	val scope = rememberCoroutineScope()
	val navController: NavHostController = rememberNavController()
	Scaffold(
		scaffoldState = scaffoldState,
		drawerContent = {
			DrawerRow("Profile", true) {

			}
		},
		topBar = {
			AppBar {
				scope.launch { scaffoldState.drawerState.open() }
			}
		},
	) {
		NavHost(navController = navController, startDestination = "profile") {
			composable("profile") { ProfileScreen(parentNavController, navController) }
			composable("internal-details") { InternalDetailsScreen() }
		}
	}
}

@Composable
fun DrawerRow(title: String, selected: Boolean, onClick: () -> Unit) {
	val background =
		if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.12f) else Color.Transparent
	val textColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface

	Text(
		color = textColor,
		text = title,
		modifier = Modifier
			.clickable(onClick = onClick)
			.background(background)
			.fillMaxWidth()
			.padding(16.dp)
	)
}

@Composable
private fun AppBar(
	onDrawerClick: () -> Unit
) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(60.dp)
			.background(MaterialTheme.colorScheme.primary)
	) {
		IconButton(
			onClick = onDrawerClick,
			modifier = Modifier.align(Alignment.CenterStart)
		) {
			Icon(
				imageVector = Icons.Outlined.Menu,
				tint = Color.White,
				contentDescription = "menu"
			)
		}
		Text(
			text = "TEST",
			modifier = Modifier.align(Alignment.Center),
			color = Color.White
		)
	}
}