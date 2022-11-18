package com.openwebinars.jetpackcompose.componentscatalog

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openwebinars.jetpackcompose.componentscatalog.models.Superhero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("uno", "dos", "tres")
    LazyColumn {
        item { Text(text = "Header") }
        items(7) { Text(text = "Item $it") }
        items(myList) {
            Text(text = it)
        }
        item { Text(text = "Footer") }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperheroStickyView() {
    val context = LocalContext.current
    val superheroes:Map<String,List<Superhero>> =getSuperheroes().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superheroes.forEach { publisher, mySuperhero ->
            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier.fillMaxWidth().background(Color.Red),
                    fontSize = 18.sp
                )
            }
            items(mySuperhero) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, "Has clicado en ${it.superheroName}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
@Composable
fun SuperheroWithControlView() {
    val context = LocalContext.current
    val coroutinesScope= rememberCoroutineScope()
    val rvState= rememberLazyListState()
    Column(modifier = Modifier.fillMaxWidth()){
        LazyColumn(state= rvState, verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier=Modifier.weight(1f)) {
            items(getSuperheroes()) { superhero ->
                ItemHero(superhero = superhero) {
                    Toast.makeText(context, "Has clicado en ${it.superheroName}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        val showButton by remember{
            derivedStateOf { //Si no ponemos el derivedStateOf, tecnicamente no funciona, pero si funcionara haría la comprobación a cada pixel que se mueva el rv
                rvState.firstVisibleItemIndex>0 //Si el item en el que empieza no es el primero, mostramos el botón
            }
        }
        if(showButton){
            Button(onClick = {
                coroutinesScope.launch {
                    rvState.animateScrollToItem(0)
                }

            }, modifier= Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)) {
                Text(text = "Go First!")
            }
        }

    }
    
}
@Composable
fun SuperheroView() {
/*    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
        items(getSuperheroes()){superhero->
            ItemHero(superhero=superhero)
        }
    }*/
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) { superhero ->
            ItemHero(superhero = superhero) {
                Toast.makeText(context, "Has clicado en ${it.superheroName}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperheroGridView() {
    val context = LocalContext.current
/*    LazyVerticalGrid(cells =GridCells.Fixed(3) , content = {
        items(getSuperheroes()){superhero->
            ItemHero(superhero=superhero){
                Toast.makeText(context, "Has clicado en ${it.superheroName}",Toast.LENGTH_SHORT).show()
            }
        }
    }*/
    LazyVerticalGrid(cells = GridCells.Adaptive(150.dp), content = {
        items(getSuperheroes()) { superhero ->
            ItemHero(superhero = superhero) {
                Toast.makeText(context, "Has clicado en ${it.superheroName}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    )


}

@Composable
fun ItemHero(superhero: Superhero, onItemClicked: (Superhero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onItemClicked(superhero) }

    ) {
        Column() {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = superhero.superheroName,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier.align(Alignment.End),
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperheroes(): List<Superhero> {
    return listOf(
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "James Howlett", "DC", R.drawable.logan),
        Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Daredevil", "Matt Murdock", "DC", R.drawable.daredevil),
        Superhero("Linterna verde", "Alan Scott", "DC", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),

        )
}