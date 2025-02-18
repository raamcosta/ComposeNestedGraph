package sp.bvantur.nestednavigation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.ExternalDetailsScreenDestination
import com.ramcosta.composedestinations.InternalDetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ProfileScreen(
	parentNavigator: DestinationsNavigator,
	destinationsNavigator: DestinationsNavigator
) {
	Box(modifier = Modifier
		.fillMaxSize()
		.background(Color.Red)) {
		Column {
			Button(onClick = {
				parentNavigator.navigate(ExternalDetailsScreenDestination)
			}) {
				Text(text = "External details screen")
			}
			Spacer(Modifier.height(8.dp))
			Button(onClick = {
				destinationsNavigator.navigate(InternalDetailsScreenDestination)
			}) {
				Text(text = "Inside details screen")
			}
		}
	}
}