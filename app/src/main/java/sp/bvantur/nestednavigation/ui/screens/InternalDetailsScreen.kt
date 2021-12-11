package sp.bvantur.nestednavigation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ramcosta.composedestinations.InternalDetailsScreen2Destination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun InternalDetailsScreen(
	parentNavigator: DestinationsNavigator,
	destinationsNavigator: DestinationsNavigator
) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Red)
	) {
		Text("Internal details 1")
		Button(onClick = {
			destinationsNavigator.navigate(
				InternalDetailsScreen2Destination.invoke(
					false
				)
			)
		}, modifier = Modifier.align(Alignment.Center)) {
			Text(text = "Details 2")
		}
	}
}