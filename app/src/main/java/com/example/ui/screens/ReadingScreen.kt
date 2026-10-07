package com.example.ui.screens

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AppPreferences
import com.example.data.ChalisaData
import com.example.data.LanguageOption
import com.example.data.TextScale
import com.example.model.ChalisaVerse
import com.example.model.VerseType
import com.example.ui.theme.SacredGold
import com.example.ui.theme.SaffronPrimary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingScreen(
    preferences: AppPreferences,
    initialVerseIndex: Int = 0,
    onBack: () -> Unit
) {
    BackHandler { onBack() }

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var currentIndex by remember { mutableIntStateOf(initialVerseIndex.coerceIn(0, 42)) }
    var isContinuousMode by remember { mutableStateOf(false) }
    var showJumpSheet by remember { mutableStateOf(false) }
    var showDisplayToggles by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val continuousListState = rememberLazyListState()

    // Save progress whenever index changes
    LaunchedEffect(currentIndex) {
        preferences.saveLastReadVerse(currentIndex)
    }

    // Scroll to index if changed in continuous mode
    LaunchedEffect(isContinuousMode) {
        if (isContinuousMode) {
            continuousListState.scrollToItem(currentIndex)
        }
    }

    // Font sizing based on preference text scale
    val scale = preferences.textScale.scaleFactor
    val verseFontSize = (28 * scale).sp
    val verseLineHeight = (40 * scale).sp
    val translitFontSize = (20 * scale).sp
    val translitLineHeight = (28 * scale).sp
    val meaningFontSize = (19 * scale).sp
    val meaningLineHeight = (27 * scale).sp

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = if (isContinuousMode) "सम्पूर्ण पाठ (Full Chalisa)" else ChalisaData.getVerse(currentIndex).numberTitleHindi,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1
                        )
                        Text(
                            text = if (isContinuousMode) "Scrollable View" else "${currentIndex + 1} of ${ChalisaData.verses.size}",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("reading_back_btn")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back to Home",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                actions = {
                    // Quick Font Size increment
                    IconButton(
                        onClick = {
                            val nextScale = when (preferences.textScale) {
                                TextScale.SMALL -> TextScale.MEDIUM
                                TextScale.MEDIUM -> TextScale.LARGE
                                TextScale.LARGE -> TextScale.EXTRA_LARGE
                                TextScale.EXTRA_LARGE -> TextScale.SMALL
                            }
                            preferences.updateTextScale(nextScale)
                        },
                        modifier = Modifier.testTag("reading_font_toggle")
                    ) {
                        Icon(
                            imageVector = Icons.Default.FormatSize,
                            contentDescription = "Change Text Size",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    // Card vs Continuous View Mode Toggle
                    IconButton(
                        onClick = { isContinuousMode = !isContinuousMode },
                        modifier = Modifier.testTag("reading_view_mode_toggle")
                    ) {
                        Icon(
                            imageVector = if (isContinuousMode) Icons.Default.ViewCarousel else Icons.Default.List,
                            contentDescription = if (isContinuousMode) "Switch to Card View" else "Switch to Continuous List",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    // Toggles / Options Sheet
                    IconButton(
                        onClick = { showDisplayToggles = !showDisplayToggles },
                        modifier = Modifier.testTag("reading_toggles_btn")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Tune,
                            contentDescription = "Display toggles",
                            tint = if (showDisplayToggles) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        bottomBar = {
            if (!isContinuousMode) {
                // Large High-Contrast 56dp+ Navigation Bar for Elderly / Kid Friendly
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(8.dp),
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 6.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .widthIn(max = 600.dp)
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Previous Button (Large 56dp tall)
                        OutlinedButton(
                            onClick = {
                                if (currentIndex > 0) {
                                    currentIndex--
                                }
                            },
                            enabled = currentIndex > 0,
                            modifier = Modifier
                                .weight(1f)
                                .height(58.dp)
                                .testTag("btn_prev_verse"),
                            shape = RoundedCornerShape(16.dp),
                            border = androidx.compose.foundation.BorderStroke(
                                1.5.dp,
                                if (currentIndex > 0) MaterialTheme.colorScheme.primary else Color.LightGray
                            )
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Previous Verse",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "पिछला (Prev)",
                                style = MaterialTheme.typography.labelLarge.copy(fontSize = 16.sp)
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        // Jump Menu Button in the middle
                        Surface(
                            onClick = { showJumpSheet = true },
                            modifier = Modifier
                                .height(58.dp)
                                .testTag("btn_jump_menu"),
                            shape = RoundedCornerShape(16.dp),
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                            border = androidx.compose.foundation.BorderStroke(1.dp, SacredGold.copy(alpha = 0.5f))
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(horizontal = 14.dp)
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "${currentIndex + 1} / ${ChalisaData.verses.size}",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 17.sp,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                    Text(
                                        text = "बदलें (Jump)",
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        // Next Button (Large 58dp tall)
                        Button(
                            onClick = {
                                if (currentIndex < ChalisaData.verses.lastIndex) {
                                    currentIndex++
                                }
                            },
                            enabled = currentIndex < ChalisaData.verses.lastIndex,
                            modifier = Modifier
                                .weight(1f)
                                .height(58.dp)
                                .testTag("btn_next_verse"),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        ) {
                            Text(
                                text = "अगला (Next)",
                                style = MaterialTheme.typography.labelLarge.copy(fontSize = 16.sp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "Next Verse",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Collapsible In-Line Display Toggles (Requirement 2: "Let user toggle each on/off")
            AnimatedVisibility(visible = showDisplayToggles) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                    ) {
                        Text(
                            text = "प्रदर्शन विकल्प (Display Toggles):",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            item {
                                FilterChip(
                                    selected = preferences.showDevanagari,
                                    onClick = { preferences.toggleDevanagari(!preferences.showDevanagari) },
                                    label = { Text("मूल पाठ (Hindi)") },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                                    )
                                )
                            }
                            item {
                                FilterChip(
                                    selected = preferences.showTransliteration,
                                    onClick = { preferences.toggleTransliteration(!preferences.showTransliteration) },
                                    label = { Text("Transliteration (${preferences.language.title})") },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                                    )
                                )
                            }
                            item {
                                FilterChip(
                                    selected = preferences.showHindiMeaning,
                                    onClick = { preferences.toggleHindiMeaning(!preferences.showHindiMeaning) },
                                    label = { Text("हिन्दी अर्थ") },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                                    )
                                )
                            }
                            item {
                                FilterChip(
                                    selected = preferences.showEnglishMeaning,
                                    onClick = { preferences.toggleEnglishMeaning(!preferences.showEnglishMeaning) },
                                    label = { Text("English Meaning") },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                                    )
                                )
                            }
                        }
                    }
                }
            }

            // Main Content Area
            if (isContinuousMode) {
                // Continuous Scroll Mode
                LazyColumn(
                    state = continuousListState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(ChalisaData.verses) { index, verse ->
                        VerseCard(
                            verse = verse,
                            preferences = preferences,
                            verseFontSize = verseFontSize,
                            verseLineHeight = verseLineHeight,
                            translitFontSize = translitFontSize,
                            translitLineHeight = translitLineHeight,
                            meaningFontSize = meaningFontSize,
                            meaningLineHeight = meaningLineHeight,
                            onShare = {
                                shareVerse(context, verse)
                            }
                        )
                    }
                }
            } else {
                // Single Card-by-Card View Mode (Elderly friendly with huge buttons)
                val currentVerse = ChalisaData.getVerse(currentIndex)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .widthIn(max = 650.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        VerseCard(
                            verse = currentVerse,
                            preferences = preferences,
                            verseFontSize = verseFontSize,
                            verseLineHeight = verseLineHeight,
                            translitFontSize = translitFontSize,
                            translitLineHeight = translitLineHeight,
                            meaningFontSize = meaningFontSize,
                            meaningLineHeight = meaningLineHeight,
                            onShare = {
                                shareVerse(context, currentVerse)
                            }
                        )
                    }
                }
            }
        }
    }

    // Modal Bottom Sheet for Verse-Number Jump Menu (Requirement 2)
    if (showJumpSheet) {
        ModalBottomSheet(
            onDismissRequest = { showJumpSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "सीधे श्लोक पर जाएँ (Jump to Verse)",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Text(
                    text = "Select any Doha or Chaupai to jump instantly:",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 72.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(340.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(ChalisaData.verses) { verse ->
                        val isSelected = verse.id == currentIndex
                        val shortLabel = when (verse.id) {
                            0 -> "दोहा १"
                            1 -> "दोहा २"
                            42 -> "समापन"
                            else -> "चौ० ${verse.id - 1}"
                        }

                        Surface(
                            onClick = {
                                currentIndex = verse.id
                                showJumpSheet = false
                            },
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isSelected) SacredGold else MaterialTheme.colorScheme.outline
                            ),
                            modifier = Modifier.height(54.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = shortLabel,
                                    style = MaterialTheme.typography.labelLarge.copy(
                                        fontSize = 14.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                    ),
                                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun VerseCard(
    verse: ChalisaVerse,
    preferences: AppPreferences,
    verseFontSize: androidx.compose.ui.unit.TextUnit,
    verseLineHeight: androidx.compose.ui.unit.TextUnit,
    translitFontSize: androidx.compose.ui.unit.TextUnit,
    translitLineHeight: androidx.compose.ui.unit.TextUnit,
    meaningFontSize: androidx.compose.ui.unit.TextUnit,
    meaningLineHeight: androidx.compose.ui.unit.TextUnit,
    onShare: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = androidx.compose.foundation.BorderStroke(
            1.5.dp,
            if (verse.type == VerseType.DOHA) SacredGold else MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Header: Verse Badge & Share
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (verse.type == VerseType.DOHA) SacredGold.copy(alpha = 0.2f) else MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SacredGold.copy(alpha = 0.5f))
                ) {
                    Text(
                        text = "${verse.numberTitleHindi} • ${verse.numberTitle}",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                }

                IconButton(
                    onClick = onShare,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share verse",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 1. DEVANAGARI HINDI TEXT (if toggled on)
            if (preferences.showDevanagari) {
                Text(
                    text = verse.hindiText,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = verseFontSize,
                        lineHeight = verseLineHeight,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(14.dp))
            }

            // 2. TRANSLITERATION TEXT (English / Gujarati / Marathi based on preference)
            if (preferences.showTransliteration) {
                val translitText = when (preferences.language) {
                    LanguageOption.HINDI -> verse.englishTranslit
                    LanguageOption.ENGLISH -> verse.englishTranslit
                    LanguageOption.GUJARATI -> verse.gujaratiText
                    LanguageOption.MARATHI -> verse.marathiText
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = translitText,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = translitFontSize,
                            lineHeight = translitLineHeight,
                            fontWeight = FontWeight.Medium
                        ),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
            }

            // Divider before meanings if meanings are visible
            if (preferences.showHindiMeaning || preferences.showEnglishMeaning) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // 3. HINDI MEANING (if toggled on)
            if (preferences.showHindiMeaning) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "सरल अर्थ (Hindi Meaning):",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = SacredGold
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = verse.hindiMeaning,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = meaningFontSize,
                            lineHeight = meaningLineHeight
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            // 4. ENGLISH MEANING (if toggled on)
            if (preferences.showEnglishMeaning) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "English Meaning:",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = SacredGold
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = verse.englishMeaning,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = meaningFontSize,
                            lineHeight = meaningLineHeight
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

private fun shareVerse(context: android.content.Context, verse: ChalisaVerse) {
    val shareText = buildString {
        appendLine("॥ ${verse.numberTitleHindi} (${verse.numberTitle}) ॥")
        appendLine()
        appendLine(verse.hindiText)
        appendLine()
        appendLine(verse.englishTranslit)
        appendLine()
        appendLine("भावार्थ (Hindi): ${verse.hindiMeaning}")
        appendLine()
        appendLine("English: ${verse.englishMeaning}")
        appendLine()
        appendLine("— श्री हनुमान चालीसा (Shri Hanuman Chalisa)")
    }

    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Hanuman Chalisa: ${verse.numberTitleHindi}")
        putExtra(Intent.EXTRA_TEXT, shareText)
    }
    context.startActivity(Intent.createChooser(intent, "Share Chalisa Verse"))
}
