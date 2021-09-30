<template>
  <div class="eisenhower-visualisation-quadrants">
    <eisenhower-visualisation-quadrant/>
    <eisenhower-visualisation-quadrant/>
    <eisenhower-visualisation-quadrant/>
    <eisenhower-visualisation-quadrant/>
  </div>
</template>

<script>
import EisenhowerVisualisationQuadrant from "@/components/EisenhowerVisualisationQuadrant.vue";
export default {
  name: 'EisenhowerVisualisationQuadrants',
  props: {
  },
   components: {
    EisenhowerVisualisationQuadrant
  }
}
</script>

<style>
</style>
